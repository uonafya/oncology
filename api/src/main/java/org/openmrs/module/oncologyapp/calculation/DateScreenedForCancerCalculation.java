package org.openmrs.module.oncologyapp.calculation;

import org.openmrs.Encounter;
import org.openmrs.EncounterType;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.calculation.result.SimpleResult;
import org.openmrs.module.ehrconfigs.metadata.EhrCommonMetadata;
import org.openmrs.module.kenyacore.calculation.AbstractPatientCalculation;
import org.openmrs.module.kenyacore.calculation.BooleanResult;
import org.openmrs.module.kenyacore.calculation.Calculations;
import org.openmrs.module.kenyaemr.calculation.EmrCalculationUtils;
import org.openmrs.module.metadatadeploy.MetadataUtils;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class DateScreenedForCancerCalculation extends AbstractPatientCalculation {
	
	/**
	 * @see org.openmrs.calculation.patient.PatientCalculation#evaluate(java.util.Collection,
	 *      java.util.Map, org.openmrs.calculation.patient.PatientCalculationContext)
	 */
	@Override
	public CalculationResultMap evaluate(Collection<Integer> cohort, Map<String, Object> params,
	        PatientCalculationContext context) {
		CalculationResultMap map = new CalculationResultMap();
		
		CalculationResultMap lastScreeningEncounter = Calculations.lastEncounter(
		    MetadataUtils.existing(EncounterType.class, EhrCommonMetadata._EhrEncounterTypes.ONCOLOGY_SCREENING), cohort,
		    context);
		for (Integer pId : cohort) {
			Date encounterDate = null;
			Encounter encounter = EmrCalculationUtils.encounterResultForPatient(lastScreeningEncounter, pId);
			
			if (encounter != null) {
				encounterDate = encounter.getEncounterDatetime();
			}
			
			map.put(pId, new SimpleResult(encounterDate, this));
		}
		return map;
	}
}
