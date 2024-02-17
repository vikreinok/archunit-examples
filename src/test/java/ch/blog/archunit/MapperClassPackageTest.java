package ch.blog.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = {"ch.blog.archunit"})
public class MapperClassPackageTest {

    @ArchTest
    public static final ArchRule mapper_classes_should_reside_in_mapper_package = classes()
            .that().haveSimpleNameEndingWith("Mapper")
            .should().resideInAPackage("..mapper..");
}