import { DefaultTheme } from 'styled-components';

import COLOR from './color';
import { fonts } from './font';
import ICON_SIZE from './icon';

export type ColorTypes = typeof COLOR;
export type FontTypes = typeof fonts;
export type IconSizeTypes = typeof ICON_SIZE;

export const theme: DefaultTheme = {
  COLOR,
  fonts,
  ICON_SIZE,
};
