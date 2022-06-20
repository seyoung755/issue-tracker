import instance from '@/api/core';
import { ISSUE_API } from '@/constant/api';

const issueApi = {
  getIssueList() {
    return instance({
      url: ISSUE_API.ISSUES,
      method: 'get',
    });
  },
  getIssueDetail(id: string) {
    return instance({
      url: `${ISSUE_API.ISSUES}/${id}`,
      method: 'get',
    });
  },
};

export default issueApi;
