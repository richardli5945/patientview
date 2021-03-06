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

package org.patientview.repository.impl;

import org.apache.commons.lang.StringUtils;
import org.patientview.patientview.model.MyDiabetes;
import org.patientview.repository.AbstractHibernateDAO;
import org.patientview.repository.MyDiabetesDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository(value = "myDiabetesDao")
public class MyDiabetesDaoImpl extends AbstractHibernateDAO<MyDiabetes> implements MyDiabetesDao {

    @Override
    public MyDiabetes get(String nhsno, String unitcode) {
        MyDiabetes myDiabetes = null;
        if (StringUtils.isNotEmpty(nhsno) && StringUtils.isNotEmpty(unitcode)) {
            String sql = "SELECT * FROM dia_mydiabetes "
                    + "WHERE nhsno = :nhsno "
                    + "AND unitcode = :unitcode ";

            Query query = getEntityManager().createNativeQuery(sql, MyDiabetes.class);

            query.setParameter("nhsno", nhsno);
            query.setParameter("unitcode", unitcode);

            List<MyDiabetes> list = query.getResultList();
            if (!list.isEmpty()) {
                myDiabetes = list.get(0);
            }
        }
        return myDiabetes;
    }
}
