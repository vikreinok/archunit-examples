package ch.blog.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = {"ch.blog.archunit"})
public class GeneralArchUnitTest {

    @ArchTest
    public static final ArchRule should_not_use_printf_debugging = noClasses().should(GeneralCodingRules.ACCESS_STANDARD_STREAMS);

    @ArchTest
    public static final ArchRule should_not_use_joda_time = noClasses().should(GeneralCodingRules.USE_JODATIME);

}