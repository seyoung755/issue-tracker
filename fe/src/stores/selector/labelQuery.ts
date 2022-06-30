import { selector } from 'recoil';

import labelApi from '@/api/label';
import { mockLabels } from '@/mocks/label/data';
import { labelListState } from '@/stores/atoms/label';
import { LabelType } from '@/types/labelTypes';

export const labelQuery = selector<LabelType[]>({
  key: 'labelQuery',
  get: async ({ get }) => {
    const labelList = get(labelListState);
    // TODO: 반복되는 try, catch utils로 빼기
    try {
      const response = await labelApi.getLabels();
      // return response.data.labels;
      return mockLabels;
    } catch (error) {
      // TODO: 에러처리 로직 구체화하기 (error-boundary적용)
      console.error(error);
      return [];
    }
  },
});
