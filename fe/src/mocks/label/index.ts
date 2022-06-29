import { rest } from 'msw';

import { API_PREFIX, LABEL_API } from '@/constant/api';
import { mockLabels } from '@/mocks/label/data';

const labelHandler = [
  rest.get(API_PREFIX + LABEL_API.LABELS, (req, res, ctx) => {
    return res(ctx.delay(2000), ctx.delay(2000), ctx.status(200), ctx.json(mockLabels));
  }),
];

export default labelHandler;
