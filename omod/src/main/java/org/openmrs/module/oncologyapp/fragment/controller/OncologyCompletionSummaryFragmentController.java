package org.openmrs.module.oncologyapp.fragment.controller;

import org.openmrs.Encounter;
import org.openmrs.PatientProgram;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.fragment.FragmentModel;

import java.util.LinkedHashMap;
import java.util.Map;

public class OncologyCompletionSummaryFragmentController {

    public String controller(@FragmentParam("patientProgram") PatientProgram enrollment,
                             @FragmentParam(value = "encounter", required = false) Encounter encounter,
                             @FragmentParam("showClinicalData") boolean showClinicalData,
                             FragmentModel model) {

        Map<String, Object> dataPoints = new LinkedHashMap<String, Object>();

        dataPoints.put("Completed", enrollment.getDateCompleted());

        model.put("dataPoints", dataPoints);
        return "view/dataPoints";
    }
}
