import { ISSUE_API } from '@/constant/api';

import apiInstance from './instances/apiInstance';

const issueApi = {
  getIssueList() {
    return apiInstance({
      url: ISSUE_API.ISSUES,
      method: 'get',
    });
  },
  getIssueDetail(id: string) {
    return apiInstance({
      url: `${ISSUE_API.ISSUES}/${id}`,
      method: 'get',
    });
  },
};

export default issueApi;
