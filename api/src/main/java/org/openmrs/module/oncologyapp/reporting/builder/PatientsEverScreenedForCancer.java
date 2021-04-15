package org.openmrs.module.oncologyapp.reporting.builder;

import org.openmrs.module.kenyacore.report.CohortReportDescriptor;
import org.openmrs.module.kenyacore.report.builder.Builds;
import org.openmrs.module.kenyacore.report.builder.CalculationReportBuilder;
import org.openmrs.module.kenyacore.report.data.patient.definition.CalculationDataDefinition;
import org.openmrs.module.kenyaemr.reporting.data.converter.CalculationResultConverter;
import org.openmrs.module.oncologyapp.calculation.DateScreenedForCancerCalculation;
import org.openmrs.module.reporting.dataset.definition.PatientDataSetDefinition;
import org.springframework.stereotype.Component;

@Component
@Builds({ "oncologyapp.cancer.report.ever.screened" })
public class PatientsEverScreenedForCancer extends CalculationReportBuilder {
	
	@Override
	protected void addColumns(CohortReportDescriptor report, PatientDataSetDefinition dsd) {
		addStandardColumns(report, dsd);
		dsd.addColumn("Screening date", new CalculationDataDefinition("Screening date",
		        new DateScreenedForCancerCalculation()), "", new CalculationResultConverter());
	}
}
