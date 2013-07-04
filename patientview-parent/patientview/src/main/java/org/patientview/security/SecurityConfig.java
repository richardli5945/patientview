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
package org.patientview.security;

/**
 *      Used to annotate service level methods that require security in addition to Role.
 */
public final class SecurityConfig {

    private SecurityConfig() {

    }

    public static final String UNIT_ACCESS = "UNIT_ACCESS";

    public static final String USER_MANAGER_SAVE = "save";

    public static final String USER_MANAGER_GET = "get";

    public static final String USER_MANAGER_SAVE_USER_FROM_UNIT_ADMIN = "saveUserFromUnitAdmin";

    public static final String USER_MANAGER_SAVE_USER_FROM_PATIENT = "saveUserFromPatient";

    public static final String USER_MANAGER_DELETE = "delete";

    public static final String PATIENT_MANAGER_GET = "get";

}
