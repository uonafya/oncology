package org.openmrs.module.oncologyapp.reporting.builder;

import org.openmrs.Concept;
import org.openmrs.Obs;
import org.openmrs.api.context.Context;
import org.openmrs.module.kenyacore.report.CohortReportDescriptor;
import org.openmrs.module.kenyacore.report.builder.Builds;
import org.openmrs.module.kenyacore.report.builder.CalculationReportBuilder;
import org.openmrs.module.kenyacore.report.data.patient.definition.CalculationDataDefinition;
import org.openmrs.module.kenyaemr.calculation.library.hiv.CountyAddressCalculation;
import org.openmrs.module.kenyaemr.calculation.library.hiv.SubCountyAddressCalculation;
import org.openmrs.module.kenyaemr.reporting.data.converter.CalculationResultConverter;
import org.openmrs.module.oncologyapp.OncologyappConstants;
import org.openmrs.module.oncologyapp.calculation.DateScreenedForCancerCalculation;
import org.openmrs.module.reporting.common.TimeQualifier;
import org.openmrs.module.reporting.data.converter.DataConverter;
import org.openmrs.module.reporting.data.person.definition.ObsForPersonDataDefinition;
import org.openmrs.module.reporting.dataset.definition.PatientDataSetDefinition;
import org.springframework.stereotype.Component;

@Component
@Builds({ "oncologyapp.cancer.report.ever.screened" })
public class PatientsEverScreenedForCancer extends CalculationReportBuilder {
	
	@Override
	protected void addColumns(CohortReportDescriptor report, PatientDataSetDefinition dsd) {
		Concept visitType = Context.getConceptService().getConceptByUuid(OncologyappConstants.TYPE_OF_VISIT);
		/*
		//Client name
		//Age
		//Sex
		//County
		//Sub county
		//Date of screening visit
		//Type of visit
		//Type of cancer screened
		Screening test
		Screening results
		Date further evaluation done
		*/
		addStandardColumns(report, dsd);
		dsd.addColumn("County", new CalculationDataDefinition("County", new CountyAddressCalculation()), "",
		    new CalculationResultConverter());
		dsd.addColumn("Sub county", new CalculationDataDefinition("Sub county", new SubCountyAddressCalculation()), "",
		    new CalculationResultConverter());
		dsd.addColumn("Date of screening visit", new CalculationDataDefinition("Date of screening visit",
		        new DateScreenedForCancerCalculation()), "", new CalculationResultConverter());
		dsd.addColumn("Type of visit", new ObsForPersonDataDefinition("Type of visit", TimeQualifier.LAST, visitType, null,
		        null), "onOrBefore=${endDate}", new CalculationResultConverter());
		dsd.addColumn("Type of cancer screened", new ObsForPersonDataDefinition("TType of cancer screened",
		        TimeQualifier.LAST, visitType, null, null), "onOrBefore=${endDate}", new CalculationResultConverter());
		
	}
}
