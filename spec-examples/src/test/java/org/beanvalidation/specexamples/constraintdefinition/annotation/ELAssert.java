/*
 * Bean Validation: constrain once, validate everywhere.
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.beanvalidation.specexamples.constraintdefinition.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintTarget;
import javax.validation.Payload;

//tag::include[]
/**
 * EL expression to be validated. This constraint accepts any type and can validate both the annotated type or apply
 * restrictions across parameters.
 */
@Documented
@Constraint(validatedBy = ELAssertValidator.class)
@Target({ METHOD, FIELD, TYPE, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface ELAssert {

	String message() default "{com.acme.constraint.DateParametersConsistent.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	ConstraintTarget validationAppliesTo() default ConstraintTarget.IMPLICIT;

	String expression();
}
// end::include[]
