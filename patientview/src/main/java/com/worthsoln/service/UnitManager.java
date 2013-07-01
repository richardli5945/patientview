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

package com.worthsoln.service;

import com.worthsoln.patientview.logon.UnitAdmin;
import com.worthsoln.patientview.model.Specialty;
import com.worthsoln.patientview.model.Unit;
import com.worthsoln.patientview.model.UnitStat;
import com.worthsoln.patientview.model.User;
import com.worthsoln.security.UnitSecured;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 *
 */
@Transactional(propagation = Propagation.REQUIRED)
@Secured(value = { "ROLE_ANY_USER" })
public interface UnitManager {

    Unit get(Long id);

    @UnitSecured(value = "UNIT_ACCESS")
    Unit get(String unitCode);

    void save(Unit unit);

    List<Unit> getAllDisregardingSpeciality(boolean sortByName);

    List<Unit> getAll(boolean sortByName);

    List<Unit> getAll(String[] sourceTypesToExclude, String[] sourceTypesToInclude);

    List<Unit> getAdminsUnits();

    List<Unit> getUnitsWithUser();

    List<Unit> getLoggedInUsersUnits();

    List<Unit> getUsersUnits(User user);

    List<Unit> getLoggedInUsersUnits(String[] notTheseUnitCodes, String[] plusTheseUnitCodes);

    List<String> getUsersUnitCodes(User user);

    List<UnitStat> getPatientCountsForUnit(String unitCode);

    List<UnitStat> getUnitStatsForUnit(String unitCode);

    List<UnitAdmin> getUnitUsers(String unitcode);

    List<User> getUnitPatientUsers(String unitcode, Specialty specialty);
}
