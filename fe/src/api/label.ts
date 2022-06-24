import instance from '@/api/core';
import { LABEL_API } from '@/constant/api';

const labelApi = {
  getLabels() {
    return instance({
      url: LABEL_API.LABELS,
      method: 'get',
    });
  },
};

export default labelApi;
