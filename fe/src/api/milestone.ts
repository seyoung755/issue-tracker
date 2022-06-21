import instance from '@/api/core';
import { MILESTONE_API } from '@/constant/api';

const milestoneApi = {
  getMileStones() {
    return instance({
      url: MILESTONE_API.MILESTONES,
      method: 'get',
    });
  },
};

export default milestoneApi;
