import { DefaultTheme } from 'styled-components';

import { buttonSizes } from './button';
import { colors } from './color';
import { fonts } from './font';
import { iconSizes } from './icon';
import { textInputSizes } from './textInput';

export type ColorsTypes = typeof colors;
export type FontTypes = typeof fonts;
export type IconSizeTypes = typeof iconSizes;
export type ButtonSizeTypes = typeof buttonSizes;
export type TextInputSizesTypes = typeof textInputSizes;

export const theme: DefaultTheme = {
  colors,
  fonts,
  iconSizes,
  buttonSizes,
  textInputSizes,
};
