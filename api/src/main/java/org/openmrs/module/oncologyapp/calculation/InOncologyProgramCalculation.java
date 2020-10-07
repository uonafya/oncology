package org.openmrs.module.oncologyapp.calculation;

import org.openmrs.Program;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.module.ehrconfigs.metadata.EhrCommonMetadata;
import org.openmrs.module.kenyacore.calculation.AbstractPatientCalculation;
import org.openmrs.module.kenyacore.calculation.Calculations;
import org.openmrs.module.kenyacore.calculation.Filters;
import org.openmrs.module.metadatadeploy.MetadataUtils;

import java.util.Collection;
import java.util.Map;

public class InOncologyProgramCalculation extends AbstractPatientCalculation {
	
	/**
	 * @see org.openmrs.calculation.patient.PatientCalculation#evaluate(java.util.Collection,
	 *      java.util.Map, org.openmrs.calculation.patient.PatientCalculationContext)
	 */
	@Override
	public CalculationResultMap evaluate(Collection<Integer> cohort, Map<String, Object> params,
	        PatientCalculationContext context) {
		return passing(Calculations.activeEnrollment(
		    MetadataUtils.existing(Program.class, EhrCommonMetadata._EhrPrograms.ONCOLOGY_PROGRAM),
		    Filters.alive(cohort, context), context));
	}
}
