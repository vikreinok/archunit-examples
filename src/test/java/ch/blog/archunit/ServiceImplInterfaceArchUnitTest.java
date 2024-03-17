package ch.blog.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.core.domain.JavaClass.Predicates.simpleNameEndingWith;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = {"ch.blog.archunit"})
public class ServiceImplInterfaceArchUnitTest {

    @ArchTest
    public static final ArchRule service_impl_classes_should_implement_service_interface =
            classes().that().haveSimpleNameEndingWith("ServiceImpl")
            .should().implement(simpleNameEndingWith("Service"));

}