import styled from 'styled-components';

import { IconSizeTypes } from '@/styles/theme';

export const Icon = styled.img<{ size: keyof IconSizeTypes }>``;
// FIXME: 타입에러
// /* ${({ theme }) => theme.iconSizes[]} */
