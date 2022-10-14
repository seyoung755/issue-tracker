import { MILESTONE_API } from '@/constant/api';

import apiInstance from './instances/apiInstance';

const milestoneApi = {
  getMileStones() {
    return apiInstance({
      url: MILESTONE_API.MILESTONES,
      method: 'get',
    });
  },
};

export default milestoneApi;
