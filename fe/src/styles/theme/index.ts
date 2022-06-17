import { DefaultTheme } from 'styled-components';

import COLOR from './color';
import FONT from './font';
import ICON_SIZE from './icon';

const fonts = {
  // logo
  logotypeLarge: {
    'font-family': `${FONT.FAMILY.LOGO}`,
    'font-style': `${FONT.STYLE.LOGO}`,
    'font-size': `${FONT.SIZE.X_LARGE}`,
    'line-height': '72px',
    'letter-spacing': '-0.04em',
  },
  logotypeRegular: {
    'font-family': `${FONT.FAMILY.LOGO}`,
    'font-style': `${FONT.STYLE.LOGO}`,
    'font-weight': `${FONT.WEIGHT.MEDIUM}`,
    'font-size': `${FONT.SIZE.LARGE}`,
    'line-height': '40px',
    'letter-spacing': '-0.04em',
  },
  // link
  linkMedium: {
    'font-weight': '700',
    'font-size': '18px',
    'line-height': `${FONT.SIZE.LARGE}`,
  },
  linkSmall: {
    'font-weight': '700',
    'font-size': `${FONT.SIZE.BASE}`,
    'line-height': '28px',
  },
  linkXSmall: {
    'font-weight': '700',
    'font-size': `${FONT.SIZE.X_SMALL}`,
    'line-height': '20px',
  },
  // text
  textLarge: {
    'font-size': '24px',
    'line-height': '40px',
  },
  textMedium: {
    'font-size': `${FONT.SIZE.MEDIUM}`,
    'line-height': `${FONT.SIZE.LARGE}`,
  },
  textSmall: {
    'font-size': `${FONT.SIZE.BASE}`,
    'line-height': '28px',
  },
  textXSamll: {
    'font-weight': '500',
    'font-size': `${FONT.SIZE.X_SMALL}`,
    'line-height': '20px',
  },
  // chore
  display: {
    'font-size': `${FONT.SIZE.LARGE}`,
    'line-height': '48px',
  },
};

export type ColorTypes = typeof COLOR;
export type FontTypes = typeof fonts;
export type IconSizeTypes = typeof ICON_SIZE;

export const theme: DefaultTheme = {
  COLOR,
  fonts,
  ICON_SIZE,
};
