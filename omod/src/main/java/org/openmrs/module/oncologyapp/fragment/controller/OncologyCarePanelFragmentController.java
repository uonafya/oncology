package org.openmrs.module.oncologyapp.fragment.controller;

import org.openmrs.Patient;
import org.openmrs.calculation.result.CalculationResult;
import org.openmrs.ui.framework.annotation.FragmentParam;
import org.openmrs.ui.framework.fragment.FragmentModel;

import java.util.HashMap;
import java.util.Map;

public class OncologyCarePanelFragmentController {

    public void controller(@FragmentParam("patient") Patient patient,
                           @FragmentParam("complete") Boolean complete,
                           FragmentModel model
    ) {

        Map<String, CalculationResult> calculationResults = new HashMap<String, CalculationResult>();
        model.put("test", "Testing summary");
    }
}
