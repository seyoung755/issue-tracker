import { DefaultTheme } from 'styled-components';

import COLOR from './color';

const fonts = {
  // logo
  logotypeLarge: {
    'font-family': 'Montserrat',
    'font-style': 'italic',
    'font-size': '56px',
    'line-height': '72px',
    'letter-spacing': '-0.04em',
  },
  logotypeRegular: {
    'font-family': 'Montserrat',
    'font-style': 'italic',
    'font-weight': 500,
    'font-size': '32px',
    'line-height': '40px',
    'letter-spacing': '-0.04em',
  },
  // link
  linkMedium: {
    'font-weight': 700,
    'font-size': '18px',
    'line-height': '32px',
  },
  linkSmall: {
    'font-weight': 700,
    'font-size': '16px',
    'line-height': '28px',
  },
  linkXSmall: {
    'font-weight': 700,
    'font-size': '12px',
    'line-height': '20px',
  },
  // text
  textLarge: {
    'font-weight': 400,
    'font-size': '24px',
    'line-height': '40px',
  },
  textMedium: {
    'font-size': '18px',
    'line-height': '32px',
  },
  textSmall: {
    'font-weight': 400,
    'font-size': '16px',
    'line-height': '28px',
  },
  textXSamll: {
    'font-weight': 500,
    'font-size': '12px',
    'line-height': '20px',
  },
  // chore
  display: {
    'font-weight': 400,
    'font-size': '32px',
    'line-height': '48px',
  },
};

export type ColorTypes = typeof COLOR;
export type FontTypes = typeof fonts;

export const theme: DefaultTheme = {
  COLOR,
  fonts,
};
