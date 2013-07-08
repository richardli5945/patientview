/*
 * PatientView
 *
 * Copyright (c) Worth Solutions Limited 2004-2013
 *
 * This file is part of PatientView.
 *
 * PatientView is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 * PatientView is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with PatientView in a file
 * titled COPYING. If not, see <http://www.gnu.org/licenses/>.
 *
 * @package PatientView
 * @link http://www.patientview.org
 * @author PatientView <info@patientview.org>
 * @copyright Copyright (c) 2004-2013, Worth Solutions Limited
 * @license http://www.gnu.org/licenses/gpl-3.0.html The GNU General Public License V3.0
 */

package com.worthsoln.service.impl;

import com.worthsoln.patientview.model.Patient;
import com.worthsoln.repository.PatientDao;
import com.worthsoln.service.PatientImporterManager;
import com.worthsoln.service.TestResultManager;
import com.worthsoln.service.LetterManager;
import com.worthsoln.service.MedicineManager;
import com.worthsoln.service.DiagnosisManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 *
 */
@Service(value = "patientImporterManager")
public class PatientImporterManagerImpl implements PatientImporterManager {

    @Inject
    private TestResultManager testResultManager;

    @Inject
    private LetterManager letterManager;

    @Inject
    private MedicineManager medicineManager;

    @Inject
    private DiagnosisManager diagnosisManager;

    @Inject
    private PatientDao patientDao;

    @Override
    public void save(Patient patient) {
        patientDao.save(patient);
    }

    @Override
    public void delete(String nhsno, String unitcode) {
        patientDao.delete(nhsno, unitcode);
    }

    @Override
    public void removePatientFromSystem(String nhsno, String unitcode) {
        // remove all the patiens content
        testResultManager.deleteTestResults(nhsno, unitcode);
        letterManager.delete(nhsno, unitcode);
        medicineManager.delete(nhsno, unitcode);
        diagnosisManager.deleteOtherDiagnoses(nhsno, unitcode);

        // finally remove the patient
        delete(nhsno, unitcode);
    }

    @Override
    public List<Patient> get(String unitCode) {
        return patientDao.get(unitCode);
    }

    @Override
    public List<Patient> getUktPatients() {
        return patientDao.getUktPatients();
    }
}
