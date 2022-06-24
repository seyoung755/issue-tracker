import { useState } from 'react';

interface StringObject {
  [key: string]: string;
}
interface ErrorProps {
  minLength?: boolean;
  maxLength?: boolean;
  pattern?: boolean;
}
interface ErrorsProps {
  [key: string]: ErrorProps;
}

interface RegisterOptionsProps {
  minLength?: number;
  maxLength?: number;
  pattern?: RegExp;
}

export default function useForm() {
  const [values, setValues] = useState<StringObject>({});
  const [errors, setErrors] = useState<ErrorsProps>({});
  const [isLoading, setIsLoading] = useState(false);

  const validate = (name: string, value: string, options: RegisterOptionsProps) => {
    const error: ErrorProps = {};
    if (!!options.minLength && value.length < options.minLength) {
      error.minLength = true;
    } else if (!!options.maxLength && value.length > options.maxLength) {
      error.maxLength = true;
    }
    if (!!options.pattern && value.match(options.pattern) === null) {
      error.pattern = true;
    }
    setErrors({ ...errors, [name]: error });
  };

  const register = (name: string, options: RegisterOptionsProps) => {
    const onChange = (e: React.ChangeEvent<HTMLInputElement>) => {
      const value = e.target.value;
      validate(name, value, options);
      setValues({ ...values, [e.target.name]: e.target.value });
    };
    return {
      value: values[name],
      onChange,
    };
  };

  const handleSubmit = (onSubmit: any) => {
    return async (e: React.FormEvent<HTMLFormElement>) => {
      e.preventDefault();
      const isValid = Object.values(errors).every(error => Object.values(error).length === 0);
      if (!isValid) {
        return;
      }
      if (!isLoading) {
        setIsLoading(true);
        await onSubmit(values);
        setIsLoading(false);
      }
    };
  };

  return {
    register,
    values,
    errors,
    handleSubmit,
  };
}
