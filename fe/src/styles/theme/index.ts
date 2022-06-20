import { DefaultTheme } from 'styled-components';

import { colors } from './color';
import { fonts } from './font';
import ICON_SIZE from './icon';

export type ColorsTypes = typeof colors;
export type FontTypes = typeof fonts;
export type IconSizeTypes = typeof ICON_SIZE;

export const theme: DefaultTheme = {
  colors,
  fonts,
  ICON_SIZE,
};
