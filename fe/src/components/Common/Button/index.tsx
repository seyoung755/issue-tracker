import { ReactNode, forwardRef } from 'react';
import { CSSProp } from 'styled-components';

import * as S from './style';

export interface ButtonProps {
  children: ReactNode;
  onClick: () => void;
  isSecondary?: boolean;
  disabled?: boolean;
  className?: string;
  customStyle?: CSSProp | null | undefined;
}

export const Button = forwardRef(
  ({
    children,
    onClick,
    disabled = false,
    isSecondary = false,
    className,
    customStyle,
  }: ButtonProps) => {
    const Style = isSecondary ? S.Secondary : S.Button;
    return (
      <Style className={className} onClick={onClick} disabled={disabled} customStyle={customStyle}>
        {children}
      </Style>
    );
  },
);

export const TextButton = forwardRef(
  ({ children, onClick, disabled = false, className, customStyle }: ButtonProps) => {
    return (
      <S.TextButton
        className={className}
        onClick={onClick}
        disabled={disabled}
        customStyle={customStyle}
      >
        {children}
      </S.TextButton>
    );
  },
);
