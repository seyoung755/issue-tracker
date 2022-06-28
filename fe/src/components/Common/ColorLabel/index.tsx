import { CSSProp } from 'styled-components';

import { IconSizeTypes } from '@/styles/theme';

import * as S from './style';

interface ColorLabelProps {
  backgroundColor: string;
  fontColor?: string;
  customStyle?: CSSProp;
  size?: keyof IconSizeTypes;
}

export default function ColorLabel({
  backgroundColor,
  fontColor,
  customStyle,
  size = 'base',
}: ColorLabelProps) {
  return (
    <S.ColorLabel
      backgroundColor={backgroundColor}
      fontColor={fontColor}
      customStyle={customStyle}
      size={size}
    />
  );
}
