package com.worthsoln.repository.messaging;

import com.worthsoln.patientview.model.GroupMessage;
import com.worthsoln.patientview.model.Message;
import com.worthsoln.patientview.model.enums.GroupEnum;

import java.util.List;

public interface GroupMessageDao {

    void save(GroupMessage groupMessage);

    int getNumberOfUnreadMessages(Long conversationId, GroupEnum groupEnum);

    GroupMessage get(Long recipientId, Long conversationId);

}