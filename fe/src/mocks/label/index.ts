import { rest } from 'msw';

import { mockLabels } from '@/mocks/label/data';

const labelHandler = [
  rest.get('/labels', (req, res, ctx) => {
    return res(ctx.status(200), ctx.json(mockLabels));
  }),
];

export default labelHandler;
