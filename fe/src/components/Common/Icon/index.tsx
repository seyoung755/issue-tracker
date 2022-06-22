import styled, { css, CSSProp } from 'styled-components';

import { Icons, IconsType } from '@/assets/icons';
import { IconSizeTypes } from '@/styles/theme';

export interface IconPropsType {
  iconName: IconsType;
  iconSize?: keyof IconSizeTypes;
  className?: string;
  customStyle?: CSSProp | null | undefined;
}

export default function Icon({
  iconName,
  iconSize = 'base',
  className,
  customStyle,
}: IconPropsType) {
  const StyledIcon = styled(Icons[iconName])`
    ${({ theme }) =>
      css`
        ${theme.iconSizes[iconSize]}
      `}

    & path {
      /* fill: backgroundColor */
      /* stroke: border(line) color */
    }

    ${customStyle &&
    css`
      ${customStyle};
    `}
  `;
  return <StyledIcon className={className} />;
}
