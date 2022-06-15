import { setupWorker } from 'msw';
import handlers from '@/mocks/handler';

export const worker = setupWorker(...handlers);
