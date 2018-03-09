using System;
using System.Runtime.Serialization;

namespace ClietnCDN
{
    [Serializable]
    internal class MethodNotAllowedHttpException : Exception
    {
        public MethodNotAllowedHttpException()
        {
        }

        public MethodNotAllowedHttpException(string message) : base(message)
        {
        }

        public MethodNotAllowedHttpException(string message, Exception innerException) : base(message, innerException)
        {
        }

        protected MethodNotAllowedHttpException(SerializationInfo info, StreamingContext context) : base(info, context)
        {
        }
    }
}