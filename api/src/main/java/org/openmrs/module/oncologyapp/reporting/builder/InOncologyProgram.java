package org.openmrs.module.oncologyapp.reporting.builder;

import org.openmrs.module.kenyacore.report.CohortReportDescriptor;
import org.openmrs.module.kenyacore.report.builder.Builds;
import org.openmrs.module.kenyacore.report.builder.CalculationReportBuilder;
import org.openmrs.module.reporting.dataset.definition.PatientDataSetDefinition;
import org.springframework.stereotype.Component;

@Component
@Builds({ "oncologyapp.cancer.report.inProgram" })
public class InOncologyProgram extends CalculationReportBuilder {
	
	@Override
	protected void addColumns(CohortReportDescriptor report, PatientDataSetDefinition dsd) {
		addStandardColumns(report, dsd);
	}
}
