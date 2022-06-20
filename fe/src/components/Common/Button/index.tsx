import { ReactNode } from 'react';
import { CSSProp } from 'styled-components';

import * as S from './style';

export interface ButtonProps {
  children: ReactNode;
  onClick: () => void;
  disabled?: boolean;
  className?: string;
  customStyle?: CSSProp | null | undefined;
}

export default function Button({
  children,
  onClick,
  disabled = false,
  className,
  customStyle,
}: ButtonProps) {
  return (
    <S.Button className={className} onClick={onClick} disabled={disabled} customStyle={customStyle}>
      {children}
    </S.Button>
  );
}
