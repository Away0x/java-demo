package ddd.leave.domain.rule.repository.facade;

import ddd.leave.domain.rule.entity.ApprovalRule;

public interface ApprovalRuleRepository {

    int getLeaderMaxLevel(ApprovalRule rule);

}
