import { createRoot } from 'react-dom/client';
import { RecoilRoot } from 'recoil';
import { ThemeProvider } from 'styled-components';

import App from '@/App';
import { worker } from '@/mocks/browser';
import GlobalStyle from '@/styles/GlobalStyles';
import { theme } from '@/styles/theme';

const container = document.getElementById('root');
const root = createRoot(container as Element);

if (process.env.MOCK_TOOL === 'msw') {
  worker.start();
}

root.render(
  <ThemeProvider theme={theme}>
    <GlobalStyle />
    <RecoilRoot>
      <App />
    </RecoilRoot>
  </ThemeProvider>,
);
