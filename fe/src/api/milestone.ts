import instance from '@/api/core';

const milestoneApi = {
  getMileStones() {
    return instance({
      url: '/milestone',
      method: 'get',
    });
  },
};

export default milestoneApi;
