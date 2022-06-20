import instance from '@/api/core';

const labelApi = {
  getLabels() {
    return instance({
      url: '/labels',
      method: 'get',
    });
  },
};

export default labelApi;
