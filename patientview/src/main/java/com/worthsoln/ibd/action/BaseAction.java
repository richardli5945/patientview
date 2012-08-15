package com.worthsoln.ibd.action;

import com.worthsoln.ibd.model.enums.AreaToDiscuss;
import com.worthsoln.ibd.model.enums.BodyPartAffected;
import com.worthsoln.ibd.model.enums.Complication;
import com.worthsoln.ibd.model.enums.Diagnosis;
import com.worthsoln.ibd.model.enums.DiseaseExtent;
import com.worthsoln.ibd.model.enums.FamilyHistory;
import com.worthsoln.ibd.model.enums.Feeling;
import com.worthsoln.ibd.model.enums.Smoking;
import com.worthsoln.ibd.model.enums.Surgery;
import com.worthsoln.ibd.model.enums.VaccinationRecord;
import com.worthsoln.ibd.model.enums.colitis.NumberOfStoolsDaytime;
import com.worthsoln.ibd.model.enums.colitis.NumberOfStoolsNighttime;
import com.worthsoln.ibd.model.enums.colitis.PresentBlood;
import com.worthsoln.ibd.model.enums.colitis.ToiletTiming;
import com.worthsoln.ibd.model.enums.crohns.AbdominalPain;
import com.worthsoln.ibd.model.enums.crohns.MassInTummy;
import com.worthsoln.ibd.model.medication.MedicationType;
import com.worthsoln.ibd.model.medication.enums.MedicationFrequency;
import com.worthsoln.ibd.model.medication.enums.MedicationNoOf;
import com.worthsoln.patientview.model.User;
import com.worthsoln.patientview.model.UserMapping;
import com.worthsoln.patientview.user.UserUtils;
import com.worthsoln.service.ibd.IbdManager;
import com.worthsoln.utils.LegacySpringUtils;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class BaseAction extends ActionSupport {

    protected static final String SUCCESS = "success";
    protected static final String INPUT = "input";
    protected static final String ERROR = "error";

    // my ibd lists
    protected static final String DISEASE_EXTENT_LIST_PROPERTY = "diseaseExtentList";
    protected static final String DIAGNOSIS_LIST_PROPERTY = "diagnosisList";
    protected static final String COMPLICATION_LIST_PROPERTY = "complicationList";
    protected static final String FAMILY_HISTORY_LIST_PROPERTY = "familyHistoryList";
    protected static final String SMOKING_LIST_PROPERTY = "smokingList";
    protected static final String SURGERY_LIST_PROPERTY = "surgeryList";
    protected static final String BODY_PART_AFFECTED_LIST_PROPERTY = "bodyPartAffectedList";
    protected static final String VACCINATION_RECORD_LIST_PROPERTY = "vaccinationRecordList";

    // care plan lists
    protected static final String AREA_TO_DISCUSS_LIST_PROPERTY = "areaToDiscussList";
    protected static final String SCALE_LIST_PROPERTY = "scaleList";

    // medication lists
    protected static final String MEDICATION_TYPE_LIST_PROPERTY = "medicationTypeList";
    protected static final String MEDICATION_NO_OF_LIST_PROPERTY = "medicationNoOfList";
    protected static final String MEDICATION_FREQUENCY_LIST_PROPERTY = "medicationFrequencyList";

    // symptom lists
    protected static final String ABDOMINAL_PAIN_LIST_PROPERTY = "abdominalPainList";
    protected static final String FEELING_LIST_PROPERTY = "feelingList";
    protected static final String CROHNS_COMPLICATION_LIST_PROPERTY = "crohnsComplicationList";
    protected static final String MASS_IN_TUMMY_LIST_PROPERTY = "massInTummyList";
    protected static final String STOOLS_DAY_LIST_PROPERTY = "stoolsDayList";
    protected static final String STOOLS_NIGHT_LIST_PROPERTY = "stoolsNightList";
    protected static final String TOILET_TIMING_LIST_PROPERTY = "toiletTimingList";
    protected static final String PRESENT_BLOOD_LIST_PROPERTY = "presentBloodList";
    protected static final String FURTHER_COMPLICATION_LIST_PROPERTY = "furtherComplicationList";
    protected static final String OPEN_BOWEL_LIST_PROPERTY = "openBowelList";

    protected static List<ScaleItem> scaleList;
    protected static List<OpenBowel> openBowelList;

    protected List<DiseaseExtent> getDiseaseExtentList() {
        return DiseaseExtent.getAsList();
    }

    protected List<Diagnosis> getDiagnosisList() {
        return Diagnosis.getAsList();
    }

    protected List<Complication> getComplicationList() {
        return Complication.getAsList();
    }

    protected List<FamilyHistory> getFamilyHistoryList() {
        return FamilyHistory.getAsList();
    }

    protected List<Smoking> getSmokingList() {
        return Smoking.getAsList();
    }

    protected List<Surgery> getSurgeryList() {
        return Surgery.getAsList();
    }

    protected List<BodyPartAffected> getBodyPartAffectedList() {
        return BodyPartAffected.getAsList();
    }

    protected List<VaccinationRecord> getVaccinationRecordList() {
        return VaccinationRecord.getAsList();
    }

    protected List<AreaToDiscuss> getAreaToDiscussList() {
        return AreaToDiscuss.getAsList();
    }

    protected List<AbdominalPain> getAbdominalPainList() {
        return AbdominalPain.getAsList();
    }

    protected List<Feeling> getFeelingList() {
        return Feeling.getAsList();
    }

    protected List<NumberOfStoolsDaytime> getStoolsDayList() {
        return NumberOfStoolsDaytime.getAsList();
    }

    protected List<NumberOfStoolsNighttime> getStoolsNightList() {
        return NumberOfStoolsNighttime.getAsList();
    }

    protected List<ToiletTiming> getToiletTimingList() {
        return ToiletTiming.getAsList();
    }

    protected List<PresentBlood> getPresentBloodList() {
        return PresentBlood.getAsList();
    }

    protected List<com.worthsoln.ibd.model.enums.colitis.Complication> getColitisComplicationList() {
        return com.worthsoln.ibd.model.enums.colitis.Complication.getAsList();
    }

    protected List<com.worthsoln.ibd.model.enums.crohns.Complication> getCrohnsComplicationList() {
        return com.worthsoln.ibd.model.enums.crohns.Complication.getAsList();
    }

    protected List<MassInTummy> getMassInTummy() {
        return MassInTummy.getAsList();
    }

    protected List<ScaleItem> getScaleList() {
        if (scaleList == null) {
            scaleList = new ArrayList<ScaleItem>();

            for (int x = 1; x <= 10; x++) {
                scaleList.add(new ScaleItem(x));
            }
        }

        return scaleList;
    }

    protected List<OpenBowel> getOpenBowelList() {
            if (openBowelList == null) {
                openBowelList = new ArrayList<OpenBowel>();

                for (int x = 1; x <= 20; x++) {
                    openBowelList.add(new OpenBowel(x));
                }
            }

            return openBowelList;
        }

    protected List<MedicationType> getMedicationTypeList() {
        return getIbdManager().getMedicationTypes();
    }

    protected List<MedicationNoOf> getMedicationNoOfList() {
        return MedicationNoOf.getAsList();
    }

    protected List<MedicationFrequency> getMedicationFrequencyList() {
        return MedicationFrequency.getAsList();
    }

    protected String getNhsNoForUser(HttpServletRequest request) {
        User user = UserUtils.retrieveUser(request);

        UserMapping userMapping = LegacySpringUtils.getUserManager().getUserMappingPatientEntered(user);

        if (userMapping != null) {
            return userMapping.getNhsno();
        }

        return null;
    }

    protected IbdManager getIbdManager() {
        // To do this without the spring action support
//        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(
//                servlet.getServletContext());

        return getWebApplicationContext().getBean(IbdManager.class);
    }

    /**
     * This is just a simple class as the struts list cant just take an array of ints
     */
    public class ScaleItem {
        private int value;

        public ScaleItem(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * This is just a simple class as the struts list cant just take an array of ints
     */
    public class OpenBowel {
        private int value;

        public OpenBowel(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
