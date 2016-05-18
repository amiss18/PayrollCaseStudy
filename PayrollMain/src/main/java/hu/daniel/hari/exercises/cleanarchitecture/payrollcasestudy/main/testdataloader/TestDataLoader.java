package hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.main.testdataloader;

import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.main.factories.usecase.UseCaseFactoriesAll;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.admin.usecase.request.addemployee.AddCommissionedEmployeeRequest;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.admin.usecase.request.addemployee.AddHourlyEmployeeRequest;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.admin.usecase.request.addemployee.AddSalariedEmployeeRequest;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.primary.admin.usecase.request.changeemployee.paymentmethod.ChangeToDirectPaymentMethodRequest;
import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ports.secondary.database.Database;

public class TestDataLoader {

	public void clearDatabaseAndInsertTestData(Database database, UseCaseFactoriesAll useCaseFactories) {
		clearDatabase(database);
		insertTestEmployees(useCaseFactories);
	}

	private void clearDatabase(Database database) {
		database.transactionalRunner().executeInTransaction(() -> 
			database.employeeGateway().deleteAll()
		);
	}

	private void insertTestEmployees(UseCaseFactoriesAll useCaseFactories) {
		useCaseFactories.addSalariedEmployeeUseCase().execute(new AddSalariedEmployeeRequest(1, "Kovács Pista", "Vác, Damjanich u. 1.", 3000));
		useCaseFactories.addHourlyEmployeeUseCase().execute(new AddHourlyEmployeeRequest(2, "Pandacsöki Boborján", "Budapest XI.", 21));
		useCaseFactories.addHourlyEmployeeUseCase().execute(new AddHourlyEmployeeRequest(3, "Telki Zoltán", "Budapest Ovari u.", 25));
		useCaseFactories.addCommissionedEmployeeUseCase().execute(new AddCommissionedEmployeeRequest(5, "Takarékos Renáta", "Mende, Gyömrői út 2", 1650, 0.15d));

		//Paymentmethods
		useCaseFactories.changeToDirectPaymentMethodUseCase().execute(new ChangeToDirectPaymentMethodRequest(1, "16200223-10041865"));
		useCaseFactories.changeToDirectPaymentMethodUseCase().execute(new ChangeToDirectPaymentMethodRequest(2, "16200010-10001040"));
	}

}
