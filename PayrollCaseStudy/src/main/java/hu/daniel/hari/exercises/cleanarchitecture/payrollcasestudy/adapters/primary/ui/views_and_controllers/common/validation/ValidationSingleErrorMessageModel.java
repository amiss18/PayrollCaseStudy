package hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.adapters.primary.ui.views_and_controllers.common.validation;

import java.util.Arrays;

public class ValidationSingleErrorMessageModel extends ValidationErrorMessagesModel {

	public ValidationSingleErrorMessageModel(String validationErrorMessage) {
		super(Arrays.asList(validationErrorMessage));
	}

}
