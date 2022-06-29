import { rest } from 'msw';

import { LABEL_API } from '@/constant/api';
import { mockLabels } from '@/mocks/label/data';

const labelHandler = [
  rest.get(LABEL_API.LABELS, (req, res, ctx) => {
    return res(ctx.status(200), ctx.json(mockLabels));
  }),
];

export default labelHandler;
