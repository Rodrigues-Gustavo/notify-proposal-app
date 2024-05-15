package com.techgustarodrigues.notify.listener;

import com.techgustarodrigues.notify.constant.ConstantMessage;
import com.techgustarodrigues.notify.entities.Proposal;
import com.techgustarodrigues.notify.service.NotificationSnsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PendingProposalListener {

    @Autowired
    private NotificationSnsService notificationSnsService;

    @RabbitListener(queues = "${rabbitmq.queue.pending.proposal}")
    public void pendingProposal(Proposal proposal) {
        String message = String.format(ConstantMessage.PROPOSAL_UNDER_ANALYSIS,proposal.getUser().getName());
        notificationSnsService.notify(proposal.getUser().getTelephone(), message);
    }
}
