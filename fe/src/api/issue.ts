import instance from '@/api/core';

const issueApi = {
  getIssueList() {
    return instance({
      url: '/issues',
      method: 'get',
    });
  },
  getIssueDetail(id: string) {
    return instance({
      url: `/issues/${id}`,
      method: 'get',
    });
  },
};

export default issueApi;
