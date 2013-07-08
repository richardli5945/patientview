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

package com.worthsoln.utils;

import com.worthsoln.service.AboutmeManager;
import com.worthsoln.service.AdminNotificationManager;
import com.worthsoln.service.CentreManager;
import com.worthsoln.service.CommentManager;
import com.worthsoln.service.DiagnosisManager;
import com.worthsoln.service.DiagnosticManager;
import com.worthsoln.service.EdtaCodeManager;
import com.worthsoln.service.EmailManager;
import com.worthsoln.service.EmailVerificationManager;
import com.worthsoln.service.FeatureManager;
import com.worthsoln.service.FeedbackManager;
import com.worthsoln.service.JoinRequestManager;
import com.worthsoln.service.LetterManager;
import com.worthsoln.service.LogEntryManager;
import com.worthsoln.service.MedicineManager;
import com.worthsoln.service.MessageManager;
import com.worthsoln.service.NewsManager;
import com.worthsoln.service.PatientManager;
import com.worthsoln.service.PatientImporterManager;
import com.worthsoln.service.ResultHeadingManager;
import com.worthsoln.service.SecurityUserManager;
import com.worthsoln.service.SplashPageManager;
import com.worthsoln.service.TestResultManager;
import com.worthsoln.service.TimeManager;
import com.worthsoln.service.UKTransplantManager;
import com.worthsoln.service.UnitManager;
import com.worthsoln.service.UserManager;
import com.worthsoln.service.ibd.IbdManager;
import com.worthsoln.service.impl.SpringApplicationContextBean;

/**
 * Used to connect up the methods in the old model classes that do service layer operations to the newer service
 * managers. We can move stuff out of this when the service/DAO code gets moved out from the model classes.
 * When/if...
 */
public final class LegacySpringUtils {

    private static AboutmeManager aboutmeManager;

    private static CentreManager centreManager;

    private static CommentManager commentManager;

    private static DiagnosisManager diagnosisManager;

    private static DiagnosticManager diagnosticManager;

    private static EdtaCodeManager edtaCodeManager;

    private static EmailVerificationManager emailVerificationManager;

    private static FeatureManager featureManager;

    private static FeedbackManager feedbackManager;

    private static LetterManager letterManager;

    private static LogEntryManager logEntryManager;

    private static MedicineManager medicineManager;

    private static NewsManager newsManager;

    private static PatientManager patientManager;

    private static PatientImporterManager patientImporterManager;

    private static ResultHeadingManager resultHeadingManager;

    private static SecurityUserManager securityUserManager;

    private static SplashPageManager splashPageManager;

    private static SpringApplicationContextBean springApplicationContextBean;

    private static TestResultManager testResultManager;

    private static TimeManager timeManager;

    private static UKTransplantManager ukTransplantManager;

    private static UnitManager unitManager;

    private static UserManager userManager;

    private static IbdManager ibdManager;

    private static MessageManager messageManager;

    private static EmailManager emailManager;

    private static JoinRequestManager joinRequestManager;

    private static AdminNotificationManager adminNotificationManager;

    private LegacySpringUtils() {

    }

    public static AboutmeManager getAboutmeManager() {
        return aboutmeManager;
    }

    public static void setAboutmeManager(AboutmeManager aboutmeManager) {
        LegacySpringUtils.aboutmeManager = aboutmeManager;
    }

    public static CentreManager getCentreManager() {
        return centreManager;
    }

    public static void setCentreManager(CentreManager centreManager) {
        LegacySpringUtils.centreManager = centreManager;
    }

    public static CommentManager getCommentManager() {
        return commentManager;
    }

    public static void setCommentManager(CommentManager commentManager) {
        LegacySpringUtils.commentManager = commentManager;
    }

    public static DiagnosisManager getDiagnosisManager() {
        return diagnosisManager;
    }

    public static void setDiagnosisManager(DiagnosisManager diagnosisManager) {
        LegacySpringUtils.diagnosisManager = diagnosisManager;
    }

    public static DiagnosticManager getDiagnosticManager() {
        return diagnosticManager;
    }

    public static void setDiagnosticManager(DiagnosticManager diagnosticManager) {
        LegacySpringUtils.diagnosticManager = diagnosticManager;
    }

    public static EdtaCodeManager getEdtaCodeManager() {
        return edtaCodeManager;
    }

    public static void setEdtaCodeManager(EdtaCodeManager edtaCodeManager) {
        LegacySpringUtils.edtaCodeManager = edtaCodeManager;
    }

    public static EmailVerificationManager getEmailVerificationManager() {
        return emailVerificationManager;
    }

    public static void setEmailVerificationManager(EmailVerificationManager emailVerificationManager) {
        LegacySpringUtils.emailVerificationManager = emailVerificationManager;
    }

    public static FeatureManager getFeatureManager() {
        return featureManager;
    }

    public static void setFeatureManager(FeatureManager featureManager) {
        LegacySpringUtils.featureManager = featureManager;
    }

    public static FeedbackManager getFeedbackManager() {
        return feedbackManager;
    }

    public static void setFeedbackManager(FeedbackManager feedbackManager) {
        LegacySpringUtils.feedbackManager = feedbackManager;
    }

    public static LetterManager getLetterManager() {
        return letterManager;
    }

    public static void setLetterManager(LetterManager letterManager) {
        LegacySpringUtils.letterManager = letterManager;
    }

    public static LogEntryManager getLogEntryManager() {
        return logEntryManager;
    }

    public static void setLogEntryManager(LogEntryManager logEntryManager) {
        LegacySpringUtils.logEntryManager = logEntryManager;
    }

    public static MedicineManager getMedicineManager() {
        return medicineManager;
    }

    public static void setMedicineManager(MedicineManager medicineManager) {
        LegacySpringUtils.medicineManager = medicineManager;
    }

    public static NewsManager getNewsManager() {
        return newsManager;
    }

    public static void setNewsManager(NewsManager newsManager) {
        LegacySpringUtils.newsManager = newsManager;
    }

    public static PatientManager getPatientManager() {
        return patientManager;
    }

    public static void setPatientManager(PatientManager patientManager) {
        LegacySpringUtils.patientManager = patientManager;
    }

    public static PatientImporterManager getPatientImporterManager() {
        return patientImporterManager;
    }

    public static void setPatientImporterManager(PatientImporterManager patientImporterManager) {
        LegacySpringUtils.patientImporterManager = patientImporterManager;
    }

    public static ResultHeadingManager getResultHeadingManager() {
        return resultHeadingManager;
    }

    public static void setResultHeadingManager(ResultHeadingManager resultHeadingManager) {
        LegacySpringUtils.resultHeadingManager = resultHeadingManager;
    }

    public static void setSecurityUserManager(SecurityUserManager securityUserManager) {
        LegacySpringUtils.securityUserManager = securityUserManager;
    }

    public static SecurityUserManager getSecurityUserManager() {
        return securityUserManager;
    }

    public static SplashPageManager getSplashPageManager() {
        return splashPageManager;
    }

    public static void setSplashPageManager(SplashPageManager splashPageManager) {
        LegacySpringUtils.splashPageManager = splashPageManager;
    }

    public static UKTransplantManager getUkTransplantManager() {
        return ukTransplantManager;
    }

    public static SpringApplicationContextBean getSpringApplicationContextBean() {
        return springApplicationContextBean;
    }

    public static void setSpringApplicationContextBean(SpringApplicationContextBean springApplicationContextBean) {
        LegacySpringUtils.springApplicationContextBean = springApplicationContextBean;
    }

    public static TestResultManager getTestResultManager() {
        return testResultManager;
    }

    public static void setTestResultManager(TestResultManager testResultManager) {
        LegacySpringUtils.testResultManager = testResultManager;
    }

    public static TimeManager getTimeManager() {
        return timeManager;
    }

    public static void setTimeManager(TimeManager timeManager) {
        LegacySpringUtils.timeManager = timeManager;
    }

    public static void setUkTransplantManager(UKTransplantManager ukTransplantManager) {
        LegacySpringUtils.ukTransplantManager = ukTransplantManager;
    }

    public static UserManager getUserManager() {
        return userManager;
    }

    public static void setUserManager(UserManager userManager) {
        LegacySpringUtils.userManager = userManager;
    }

    public static UnitManager getUnitManager() {
        return unitManager;
    }

    public static void setUnitManager(UnitManager unitManager) {
        LegacySpringUtils.unitManager = unitManager;
    }

    public static IbdManager getIbdManager() {
        return ibdManager;
    }

    public static void setIbdManager(IbdManager ibdManager) {
        LegacySpringUtils.ibdManager = ibdManager;
    }

    public static MessageManager getMessageManager() {
        return messageManager;
    }

    public static void setMessageManager(MessageManager messageManager) {
        LegacySpringUtils.messageManager = messageManager;
    }

    public static EmailManager getEmailManager() {
        return emailManager;
    }

    public static void setEmailManager(EmailManager emailManager) {
        LegacySpringUtils.emailManager = emailManager;
    }

    public static JoinRequestManager getJoinRequestManager() {
        return joinRequestManager;
    }

    public static void setJoinRequestManager(JoinRequestManager joinRequestManager) {
        LegacySpringUtils.joinRequestManager = joinRequestManager;
    }

    public static AdminNotificationManager getAdminNotificationManager() {
        return adminNotificationManager;
    }

    public static void setAdminNotificationManager(AdminNotificationManager adminNotificationManager) {
        LegacySpringUtils.adminNotificationManager = adminNotificationManager;
    }
}
