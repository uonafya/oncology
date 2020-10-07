package org.openmrs.module.oncologyapp.fragment.controller;

import org.openmrs.Encounter;
import org.openmrs.PatientProgram;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.fragment.FragmentModel;

import java.util.LinkedHashMap;
import java.util.Map;

public class OncologyEnrollmentSummaryFragmentController {

    public String controller(@FragmentParam("patientProgram") PatientProgram patientProgram,
                             @FragmentParam(value = "encounter", required = false) Encounter encounter,
                             @FragmentParam("showClinicalData") boolean showClinicalData,
                             FragmentModel model) {
        Map<String, Object> dataPoints = new LinkedHashMap<String, Object>();
        dataPoints.put("Enrolled", patientProgram.getDateEnrolled());
        model.put("dataPoints", dataPoints);

        return "view/dataPoints";
    }

    }
