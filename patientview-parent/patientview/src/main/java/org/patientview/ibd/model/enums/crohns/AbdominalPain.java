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

package org.patientview.ibd.model.enums.crohns;

import java.util.Arrays;
import java.util.List;

public enum AbdominalPain {
    NO(0, "No", 0),
    MILD(1, "Mild", 1),
    MODERATE(2, "Moderate", 2),
    SEVERE(3, "Severe", 3);

    private int id;
    private String displayText;
    private int score;

    private AbdominalPain(int id, String displayText, int score) {
        this.id = id;
        this.displayText = displayText;
        this.score = score;
    }

    public static AbdominalPain getAbdominalPain(int id) {
        for (AbdominalPain abdominalPain : AbdominalPain.values()) {
            if (abdominalPain.getId() == id) {
                return abdominalPain;
            }
        }

        return null;
    }

    public int getId() {
        return id;
    }

    public String getDisplayText() {
        return displayText;
    }

    public int getScore() {
        return score;
    }

    public static List<AbdominalPain> getAsList() {
        return Arrays.asList(AbdominalPain.values());
    }
}
