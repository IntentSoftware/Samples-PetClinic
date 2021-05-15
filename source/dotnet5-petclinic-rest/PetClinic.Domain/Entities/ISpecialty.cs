using System;
using System.Collections.Generic;
using Intent.RoslynWeaver.Attributes;

[assembly: DefaultIntentManaged(Mode.Fully)]
[assembly: IntentTemplate("Intent.Entities.DomainEntityInterface", Version = "1.0")]

namespace PetClinic.Domain.Entities
{

    public partial interface ISpecialty
    {

        int Id { get; set; }

        string Name { get; set; }

    }
}
