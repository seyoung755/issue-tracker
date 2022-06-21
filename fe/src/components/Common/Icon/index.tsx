import styled, { css } from 'styled-components';

import { Icons, IconsType } from '@/assets/icons';
import { IconSizeTypes } from '@/styles/theme';

export interface IconPropsType {
  iconName: IconsType;
  iconSize?: keyof IconSizeTypes;
}

export default function Icon({ iconName, iconSize = 'base' }: IconPropsType) {
  const StyledIcon = styled(Icons[iconName])`
    ${({ theme }) =>
      css`
        ${theme.iconSizes[iconSize]}
      `}
  `;
  return <StyledIcon />;
}
