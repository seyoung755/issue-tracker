import { LABEL_API } from '@/constant/api';

import apiInstance from './instances/apiInstance';

const labelApi = {
  getLabels() {
    return apiInstance({
      url: LABEL_API.LABELS,
      method: 'get',
    });
  },
};

export default labelApi;
