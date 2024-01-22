package ch.blog.archunit;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import java.util.Collection;
import java.util.Set;

import static com.tngtech.archunit.lang.ConditionEvent.createMessage;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static java.util.Collections.emptySet;
import static java.util.stream.Collectors.toSet;

@AnalyzeClasses(packages = {"ch.blog.archunit"})
public class MapperArchUnitTest {

    private static final String MAPPER_CLASS_SUFFIX = "Mapper";
    private static final String TEST_CLASS_SUFFIX = "Test";

    @ArchTest
    public static final ArchRule relevant_classes_should_have_tests =
            classes()
                    .that()
                    .haveSimpleNameContaining(MAPPER_CLASS_SUFFIX).and()
                    .areTopLevelClasses()
                    .and().areNotInterfaces()
                    .and().areNotRecords()
                    .and().areNotEnums()
                    .should(haveACorrespondingClassEndingWith(TEST_CLASS_SUFFIX));

    private static ArchCondition<JavaClass> haveACorrespondingClassEndingWith(String testClassSuffix) {
        return new ArchCondition<>("have a corresponding class with suffix " + testClassSuffix) {
            Set<String> testedClasseNames = emptySet();

            @Override
            public void init(Collection<JavaClass> allClasses) {
                testedClasseNames = allClasses.stream()
                        .map(JavaClass::getName)
                        .filter(className -> className.endsWith(testClassSuffix))
                        .map(className -> className.substring(0, className.length() - testClassSuffix.length()))
                        .collect(toSet());
            }

            @Override
            public void check(JavaClass clazz, ConditionEvents events) {
                if (!clazz.getName().endsWith(testClassSuffix)) {
                    boolean satisfied = testedClasseNames.contains(clazz.getName());
                    String message = createMessage(clazz, "has " + (satisfied ? "a" : "no") + " corresponding test class");
                    events.add(new SimpleConditionEvent(clazz, satisfied, message));
                }
            }
        };
    }
}