import { useState } from 'react';

interface UseFormProps<T> {
  initialValues: T;
  onSubmit(values: T): void;
}

export default function useForm<T>({ initialValues, onSubmit }: UseFormProps<T>) {
  const [values, setValues] = useState(initialValues);
  const [isValid, setIsValid] = useState(false);
  const [isLoading, setIsLoading] = useState(false);

  const validate = (form: HTMLFormElement, newValues: { [index: string]: string }) =>
    Object.keys(newValues).every(key => newValues[key].length >= form[key].minLength);

  const handleChange = ({ target }: React.FormEvent<HTMLInputElement>) => {
    const { name, value, pattern, form } = target as HTMLInputElement;
    if (!form) return;
    if (value === '' || value.match(pattern) != null) {
      const newValues = { ...values, [name]: value };
      setValues(newValues);
      setIsValid(validate(form, newValues));
    }
  };

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    if (!isLoading) {
      setIsLoading(true);
      await onSubmit(values);
      setIsLoading(false);
    }
  };

  return {
    values,
    isValid,
    isLoading,
    handleChange,
    handleSubmit,
  };
}
